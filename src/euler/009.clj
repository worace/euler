(ns euler.009
 (:require [clojure.math.combinatorics :as combo]))

;;                  [[1, 2, 2], [2, 1, 2], [2, 2, 3]],
;;                  [[1, -2, 2], [2, -1, 2], [2, -2, 3]],
;;                  [[-1, 2, 2], [-2, 1, 2], [-2, 2, 3]]


(def init-matrices
  [[[1 2 2] [2 1 2] [2 2 3]]
   [[1 -2 2] [2 -1 2] [2 -2 3]]
   [[-1 2 2] [-2 1 2] [-2 2 3]]])

(defn square [n] (* n n))

(defn triple? [v]
  (let [[a b c] v]
       (= (reduce + (map square [a b])) (square c))))

;; (2m,m^2-1,m^2+1), 	
(defn triple [m n]
  [(- (* n n) (* m m)) (* 2 m n) (+ (* n n) (* m m))])

(defn greater-than [left right]
  (= 1 (compare left right)))


(defn triples-up-to [n]
  (loop [iteration 1 triples []]
    (if (greater-than (reduce + (last triples)) n)
      triples
      (recur (+ 1 iteration) (conj triples (triple iteration (+ 1 iteration)))))))

(defn crosses-in-range [n]
  (combo/cartesian-product (range 1 n) (range 1 n)))

(defn triple-summing-to [n]
  (first (filter (fn [x] (= x n)) (triples-up-to n))))


(defn vector-product [v1 v2]
  (map (fn [pair] (reduce * pair)) (map vector v1 v2)))

(defn cross-mult [matrix vector]
  (map (fn [row] (vector-product row vector)) matrix))

(defn matrix-mult [matrix vector]
  (map (fn [v] (reduce + v)) (cross-mult matrix vector)))
