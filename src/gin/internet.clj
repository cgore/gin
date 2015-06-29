(ns gin.internet
  "Generates all sorts of Internet-related things."
  (:require [clojure.test.check.generators :as gen]))

(def ipv4-address
  "This generates IPv4 address strings, things like \"192.168.0.1\"."
  (gen/fmap #(clojure.string/join "." %)
            (gen/tuple (gen/choose 0 255)
                       (gen/choose 0 255)
                       (gen/choose 0 255)
                       (gen/choose 0 255))))

;;; TODO: add support for generating shortened IPv6 addresses.
(def ipv6-address
  "This generates IPv6 address strings, things like \"b6b5:4d8c:0d1f:4dfc:9b51:e8ba:3a39:4621\"."
  (gen/fmap #(clojure.string/join ":" %)
            (gen/vector (gen/fmap #(format "%04x" %)
                                  (gen/choose 0x0 0xffff))
                        8)))
