(ns euler.005
  (:require [clojure.math.numeric-tower :as math]))

(defn divisible [x mods]
  (or (some true? (map (fn [div]
                      (= 0 (mod x div))) mods))
   false))



(defn possible-factors [n]
 (remove (fn [x] (= x n)) (range 2 (+ 1 (math/sqrt n))))
  
 
;; range 2 (+ 1 (math/sqrt n))
)

(defn is-prime [n]
  (not (divisible n (possible-factors n)))
)

(defn divisors-up-to [n]
  (filter is-prime (range 1 (+ n 1))))

(defn lowest-multiple [n]
  (loop [multiple 1 divisors (divisors-up-to n)]
    (if (empty? divisors)
      multiple
      (let [[next & divisors] divisors]
        (if (divisible multiple [next])
          (recur multiple divisors)
          (recur (* next multiple) divisors))))))


(defn divis-by-all [x divisors]
  (every? (fn [divisor] (divisible x [divisor])) divisors))

(defn lcm [n]
  (loop [multiple 1 divisors (range 1 (+ 1 n))]
    (if (divis-by-all multiple divisors)
      multiple
      (recur (+ 1 multiple) divisors))))
