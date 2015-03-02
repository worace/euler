(ns euler.prob-eleven-test
  (:require [clojure.test :refer :all]
            [euler.011 :refer :all]))

(deftest test-exists
  (testing "it exists"
    (is (= 1 1))))

(deftest test-slicing-vectors
  (testing "it slices a vector into chunks of size n"
    (let [[v] [[1 2 3 4 5 6 7 8]]]
      (is (= 5 (count (chunks 4 v)))))))

(deftest test-matrix-slices
  (testing "it gets slices of n size in all directions"
    (let [[m] [[[1 2 3] [4 5 6] [7 8 9]]]]
      (is (= [3 6 9] (last (matrix-slices 3 m))))
      (is (= [[1 2 3]
             [4 5 6]
             [7 8 9]
             [1 4 7]
             [2 5 8]
             [3 6 9]] (matrix-slices 3 m))))))
