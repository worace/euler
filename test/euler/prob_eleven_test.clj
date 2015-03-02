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

;;[[1 2] [3 4]
;;[1 2] [3 4] [1 3] [2 4]
;;2 12 3 8
(deftest test-multiplies-matrix-slices
  (testing "it maps slices to products"
    (is (= {[1 2] 2 [3 4] 12 [1 3] 3 [2 4] 8} (slice-products 2 [[1 2] [3 4]])))))

(deftest test-finds-max-product-slice
  (testing "it gives the slice of size n which has greatest product"
    (is (= [3 4] (max-product-slice 2 [[1 2] [3 4]])))))

(deftest test-finds-the-answer
  (testing "it finds max product of our big grid"
    (is (= "?" (reduce * (max-product-slice 4 grid))))))
