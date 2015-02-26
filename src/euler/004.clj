(ns euler.004
  (:require [clojure.math.combinatorics :as combo]))

(defn cross-product [left right]
  (map (fn [pair]
         (reduce * pair))
       (combo/cartesian-product left right)))

(defn palindrome? [num]
  (= (seq (str num)) (reverse (str num))))

(defn three-digit-products []
 (cross-product (range 100 1000) (range 100 1000)))

(defn pals []
  (apply max (filter palindrome? (reverse (three-digit-products)))))
