(ns kaocha.ns
  (:refer-clojure :exclude [symbol])
  (:require [clojure.spec.alpha :as s]
            [kaocha.core-ext :refer :all]))

(defn required-ns [ns-name]
  (when-not (find-ns ns-name)
    (require ns-name))
  (try
    (the-ns ns-name)
    (catch Exception _)))

(s/def ::name simple-symbol?)
(s/def ::ns   ns?)
