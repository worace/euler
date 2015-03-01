(ns euler.010 (:require [clojure.math.numeric-tower :as math]))
;; find sum of all primes below 2 million

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
  (filter (fn [x] (not (divisible x [n]))) coll))

(defn primes-up-to [n]
  (loop [primes [] [next & remaining] (range 1 (+ 1 n))]
    (if (empty? remaining)
      primes
      (if (is-prime next)
        (recur (conj primes next) (non-multiples remaining next))
        (recur primes remaining)))))

(defn up-primes [n]
  (loop [primes [2] current 3]
    (if (= n current)
      primes
       (if (divisible current primes)
         (recur primes (+ 1 current))
         (recur (conj primes current) (+ 1 current))))))


(defn alt-primes [n]
  (filter is-prime (range 1 (+ 1 n))))

(defn sum-primes-to [n]
  (reduce + (alt-primes n)))
;;142913828922 in 35 seconds using naive solution
