(ns euler.007 (:require [clojure.math.numeric-tower :as math]))

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

(defn nth-prime [n]
  (loop [i 0 prime-count 0 last-prime nil]
    (if (= prime-count n)
      last-prime
      (if (is-prime i)
        (recur (+ 1 i) (+ 1 prime-count) i)
        (recur (+ 1 i) prime-count last-prime)))))
