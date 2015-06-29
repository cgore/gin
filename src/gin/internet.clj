(ns gin.internet
  "Generates all sorts of Internet-related things."
  (:require [clojure.test.check.generators :as gen]))

(def ipv4-address
  (gen/fmap #(clojure.string/join "." %)
            (gen/tuple (gen/choose 0 255)
                       (gen/choose 0 255)
                       (gen/choose 0 255)
                       (gen/choose 0 255))))
