(ns gin.core-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.clojure-test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [gin.core :as gin]))

(defspec floats-are-all-floats
  100
  (prop/for-all [f gin/float]
                (= java.lang.Float (class f))))

(defspec doubles-are-all-doubles
  100
  (prop/for-all [d gin/double]
                (= java.lang.Double (class d))))
