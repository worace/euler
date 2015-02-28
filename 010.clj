(ns euler.010 (:require [clojure.math.numeric-tower :as math]))

(defn divisible [x mods]
  (or (some true? (map (fn [div]
                      (= 0 (mod x div))) mods))
   false))

(defn possible-factors [n]
 (remove (fn [x] (= x n)) (range 2 (+ 1 (math/sqrt n))))
)

(defn is-prime [n]
  (and (= 1 (compare n 1)) (not (divisible n (possible-factors n))))
)

(defn non-multiples [coll n]
  (filter (fn [x] (not (divisible x n))) coll))

(defn primes-up-to [n]
  (loop [primes [] [next & remaining] (range 1 (+ 1 n))]
    (if (empty? remaining)
      primes
      (if (is-prime next)
        (recur (conj primes next) [[next & remaining] (non-multiples remaining next)])
        (recur primes [[next & remaining] remaining])))))
