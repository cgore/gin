(ns gin.core-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.clojure-test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [gin.core :as gin]))

(def runs 100)

(deftest one-test
  (testing "one generates one sample (useful for the repl mostly)"
    (is (instance? java.lang.Double (gin/one gen/double)))))

(defspec floats-are-all-floats runs
  (prop/for-all [f gin/float]
                (= java.lang.Float (class f))))

(defspec doubles-are-all-doubles runs
  (prop/for-all [d gin/double]
                (= java.lang.Double (class d))))
