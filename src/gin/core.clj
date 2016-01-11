(ns gin.core
  (:refer-clojure :exclude [double float])
  (:require [clojure.test.check.generators :as gen]))

(def double
  "This generates a java.lang.Double."
  gen/double)

(def float
  "This generates a java.lang.Float."
  (gen/fmap clojure.core/float double))
