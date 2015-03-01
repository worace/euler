(ns euler.009
 (:require [clojure.math.combinatorics :as combo]))

(def init-matrices
  [[[1 2 2] [2 1 2] [2 2 3]]
   [[1 -2 2] [2 -1 2] [2 -2 3]]
   [[-1 2 2] [-2 1 2] [-2 2 3]]])

(defn square [n] (* n n))

(defn triple? [v]
  (let [[a b c] v]
       (= (reduce + (map square [a b])) (square c))))

(defn greater-than [left right]
  (= 1 (compare left right)))

(defn vector-product [v1 v2]
  (map (fn [pair] (reduce * pair)) (map vector v1 v2)))

(defn cross-mult [matrix vector]
  (map (fn [row] (vector-product row vector)) matrix))

(defn matrix-mult [matrix vector]
  (map (fn [v] (reduce + v)) (cross-mult matrix vector)))

(defn child-triples
  ([triple num-generations]
   (loop [seeds [triple] children [] count (+ 1 num-generations)]
     (if (= count 0)
       children
       (recur (mapcat child-triples seeds) seeds (- count 1)))))
  ([triple]
   (map (fn [m] (matrix-mult m triple)) init-matrices)))

(defn sum-triples [triples]
  (map (fn [t] (reduce + t)) triples))

(defn triple-factor-of-target [target triples]
  (first (filter (fn [triple] (= 0 (mod target (reduce + triple)))) triples)))

(defn triple-scaled-to [n triple]
  (let [[factor] [(/ n (reduce + triple))]]
    (vector-product triple [factor factor factor])))

(defn triple-summing-to [n]
  (loop [target n iter 0 triples (child-triples [3 4 5] 0)]
    (let [[match] [(triple-factor-of-target target triples)]]
      (if match
        (triple-scaled-to target match)
        (if (every? (fn [t] (greater-than (reduce + t) target)) triples)
          nil
          (recur target (+ 1 iter) (child-triples [3 4 5] (+ 1 iter))))))))

