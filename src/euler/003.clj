(ns euler.003
  (:require [clojure.math.numeric-tower :as math]))
;;num: 600851475143

(defn divisible [x mods]
  (or (some true? (map (fn [div]
                      (= 0 (mod x div))) mods))
   false))

(defn possible-factors [n] (range 2  (math/sqrt n)))

(defn is-prime [n]
  (not (divisible n (possible-factors n)))
)

(defn remove-products [factor list]
 (filter (fn [n]
           (not (divisible n [factor]))) list))


(defn factors [n]
  (filter (fn [x]
           (divisible n [x])) (possible-factors n)))


(defn prime-factors [n]
  (filter is-prime (factors n)))

(defn largest-prime-factor [n]
  (last (prime-factors n)))
