(ns euler.006)

(defn square [n] (* n n))

(defn sum-squares [n]
  (reduce + (map square (range 1 (+ 1 n)))))

(defn square-sum [n]
  (square (reduce + (range 1 (+ 1 n)))))


(defn diff [n]
  (- (square-sum n) (sum-squares n)))
