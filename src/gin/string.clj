(ns gin.string
  "Generates all sorts of strings."
  (:require [clojure.test.check.generators :as gen]))

(def string-alpha
  "Generate alpha strings."
  (gen/fmap clojure.string/join
            (gen/vector gen/char-alpha)))

(def string-alpha-lower
  "Generate lower-case alpha strings"
  (gen/fmap clojure.string/lower-case string-alpha))

(def string-alpha-upper
  "Generate upper-case alpha strings"
  (gen/fmap clojure.string/upper-case string-alpha))
