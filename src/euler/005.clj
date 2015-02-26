(ns euler.005
  (:require [clojure.math.numeric-tower :as math]))

(defn divisible [x mods]
  (or (some true? (map (fn [div]
                      (= 0 (mod x div))) mods))
   false))

(defn divis-by-all [x divisors]
  (every? (fn [divisor] (divisible x [divisor])) divisors))

(defn lcm [n]
  (loop [multiple 1 divisors (range 1 (+ 1 n))]
    (if (divis-by-all multiple divisors)
      multiple
      (recur (+ 1 multiple) divisors))))
