(ns gin.char
  "Generates all sorts of strings."
  (:require [clojure.test.check.generators :as gen]))

(def alpha-lower
  "Generate lowercase alpha characters."
  (gen/fmap char
            (gen/one-of [(gen/choose 97 122)])))

(def alpha-upper
  "Generate uppercase alpha characters."
  (gen/fmap char
            (gen/one-of [(gen/choose 65 90)])))

(def hex-lower
  "Generates hex number characters, using lowercase letters for a-f."
  (gen/elements (seq "0123456789abcdef")))

(def hex-upper
  "Generates hex number characters, using uppercase letters for a-f."
  (gen/elements (seq "0123456789ABCDEF")))

(def hex
  "Generates hex number characters."
  (gen/one-of [hex-lower hex-upper]))
