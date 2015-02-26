(ns euler.002)

(defn fib [n]
  (if (= n 0)
    0
    (if (= n 1)
      1
      (+ (fib (- n 1)) (fib (- n 2))))))

(reduce +(filter even?(filter (fn [x] (> 4000000 x)) (map fib (range 0 36)))))
