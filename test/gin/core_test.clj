(ns gin.core-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.clojure-test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [gin.core :as gin]))

(def runs 100)

(defspec floats-are-all-floats runs
  (prop/for-all [f gin/float]
                (= java.lang.Float (class f))))

(defspec doubles-are-all-doubles runs
  (prop/for-all [d gin/double]
                (= java.lang.Double (class d))))
