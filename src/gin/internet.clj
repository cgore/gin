(ns gin.internet
  "Generates all sorts of Internet-related things."
  (:require [clojure.test.check.generators :as gen]
            [clojure.string :refer [join]]))

(def ipv4-address
  "This generates IPv4 address strings, things like \"192.168.0.1\"."
  (gen/fmap #(clojure.string/join "." %)
            (gen/tuple (gen/choose 0 255)
                       (gen/choose 0 255)
                       (gen/choose 0 255)
                       (gen/choose 0 255))))

;;; TODO: add support for generating shortened IPv6 addresses.
(def ipv6-address
  "This generates IPv6 address strings,
  things like \"b6b5:4d8c:0d1f:4dfc:9b51:e8ba:3a39:4621\"."
  (gen/fmap (partial join ":")
            (gen/vector (gen/fmap (partial format "%04x")
                                  (gen/choose 0x0 0xffff))
                        8)))

(def valid-domain-name-characters
  "These are all of the characters that are valid for a domain name label."
  (seq "abcdefghijklmnopqrstuvwxyz0123456789-"))

(def valid-domain-name-endcap-characters
  "These are all of the characters that are valid for the first or last
  character of a domain name label."
  (seq "abcdefghijklmnopqrstuvwxyz0123456789"))

(def domain-name-label
  "This generates domain name labels, the components of a domain name. For
  example, in the domain name 'www.foo.com', there are three labels, 'www',
  'foo', and 'com'."
  (gen/such-that #(<= 1 (count %))
                 (gen/fmap join
                           (gen/tuple (gen/elements valid-domain-name-endcap-characters)
                                      (gen/fmap join (gen/such-that #(<= 1 (count %) 61)
                                                                    (gen/vector (gen/elements valid-domain-name-characters))))
                                      (gen/elements valid-domain-name-endcap-characters)))))

(def domain-name
  "This generates a complete domain name, such as 'www.foo.com'."
  (gen/such-that #(<= 1 (count %) 253)
                 (gen/fmap (partial join ".")
                           (gen/vector domain-name-label))))

(def valid-scheme-characters
  (seq "abcdefghijklmnopqrstuvwxyz0123456789+.-"))

(def scheme
  "This generates a random valid URI scheme identifier. This is, for example,
  the 'http' in a normal web link."
  (gen/fmap #(join [(first %) (join (second %))])
            (gen/tuple gin.char/alpha-lower
                       (gen/vector (gen/elements valid-scheme-characters)))))

(def port
  "Generates a valid port number."
  (gen/choose 1 65535))
