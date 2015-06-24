(ns gin.string-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.clojure-test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [gin.string :as s]))

(def runs 100)

(defspec string-alpha-are-all-alpha runs
  (prop/for-all [s s/string-alpha]
                (re-matches #"[a-zA-Z]*" s)))

(defspec string-alpha-lower-are-all-alpha-lower runs
  (prop/for-all [s s/string-alpha-lower]
                (re-matches #"[a-z]*" s)))

(defspec string-alpha-upper-are-all-alpha-upper runs
  (prop/for-all [s s/string-alpha-upper]
                (re-matches #"[A-Z]*" s)))
