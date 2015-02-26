(ns euler.003)

(defn divisible [x mods]
  (or (some true? (map (fn [div]
                      (= 0 (mod x div))) mods))
   false))

(defn possible-factors [n] (range 2  (+ 1 (/ n 2))))

(defn is-prime [n]
  (not (divisible n (possible-factors n)))
)

(defn remove-products [factor list]
 (filter (fn [n]
           (not (divisible n [factor]))) list))

(defn factors [n]
  (loop [proved [] possible (possible-factors n)]
    (if (empty? possible)
      proved
      (let [[next & possible] possible]
        (if (= 0 (mod n next))
          (recur (conj proved next) possible)
          (recur proved (remove-products next possible))))))
)

(defn prime-factors [n]
  (filter is-prime (possible-factors n)))
