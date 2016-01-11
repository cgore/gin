(ns gin.core
  (:refer-clojure :exclude [double float])
  (:require [clojure.test.check.generators :as gen]))

(def double
  "This generates a java.lang.Double."
  gen/double)

(defn float<-double [d]
  (cond
    (= Double/NEGATIVE_INFINITY d) Float/NEGATIVE_INFINITY
    (= Double/POSITIVE_INFINITY d) Float/POSITIVE_INFINITY
    :else (try (clojure.core/float d)
               (catch Exception _ (clojure.core/float 0.0)))))

(def float
  "This generates a java.lang.Float."
  (gen/fmap float<-double double))
