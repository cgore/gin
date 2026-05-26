(ns build
  (:require [clojure.tools.build.api :as b]))

(def lib 'cgore/gin)
(def version
  "Dynamically get version from git tag (e.g. v0.4.1 → 0.4.1)"
  (-> (b/git-process {:git-args ["describe" "--tags" "--abbrev=0"]})
      (clojure.string/trim)
      (clojure.string/replace #"^v" "")))
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn jar [_]
  (clean nil)
  (b/write-pom {:class-dir class-dir
                :lib       'cgore/gin
                :version   version
                :basis     basis
                :src-dirs  ["src"]
                :pom-data  [[:description "Gin is a library of additional generally useful generators using test.check"]
                            [:url "https://github.com/cgore/gin"]
                            [:licenses
                             [:license
                              [:name "Eclipse Public License 1.0"]
                              [:url "http://www.eclipse.org/legal/epl-v10.html"]]]
                            [:scm
                             [:url "https://github.com/cgore/gin"]
                             [:connection "scm:git:git@github.com:cgore/gin.git"]]]})
  (b/copy-dir {:src-dirs ["src"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file jar-file}))

(defn install [_]
  (jar nil)
  (b/install {:basis basis
              :lib lib
              :version version
              :jar-file jar-file
              :class-dir class-dir}))
