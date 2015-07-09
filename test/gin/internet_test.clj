(ns gin.internet-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.clojure-test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [gin.internet :as inet]))

(def runs 100)

(defspec ipv4-addresses-are-all-valid
  (prop/for-all [ipv4 inet/ipv4-address]
                (re-matches #"[0-9]+\.[0-9]+\.[0-9]+\.[0-9]+" ipv4)))

(defspec schemes-are-valid
  (prop/for-all [scheme inet/scheme]
                (re-matches #"[a-z0-9+.-]+" scheme)))
