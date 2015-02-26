(ns euler.001)

(defn pizza
  []
  (println "hi"))

(defn divisible [x & mods]
  (or (some true? (map (fn [div]
                      (= 0 (mod x div))) mods))
   false))


(defn multiples-up-to
  [n]
  (filter (fn [x]
            (divisible x 3 5))
          (range 1 n)))


