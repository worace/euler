(ns euler.prob-nine-test
  (:require [clojure.test :refer :all]
            [euler.009 :refer :all]))

(deftest test-multiplying-vectors
  (testing "it cross multiplies a matrix by a vector"
    (is (= [[2 4 6] [8 10 12]] (cross-mult [[1 2 3] [4 5 6]] [2 2 2])))))

(deftest test-multiply-two-vectors
  (testing "it multiplies 2 vectors"
    (is (= [2 4 6] (vector-product [1 2 3] [2 2 2])))))

(deftest test-base-matrices
  (testing "it knows the three triple initialization matrices"
    (is (= [2 2 3] (last (first init-matrices))))))

(deftest test-is-p-triple
  (testing "it can tell if a vector is a pythagorean triple"
    (is (triple? [3 4 5]))
    (is (not (triple? [4 5 6])))))

(deftest test-matrix-mult
  (testing "multiplies matrix by vector and reduces to a vector of same length"
    (is [21 20 29] (matrix-mult (first init-matrices) [3 4 5]))))

(deftest test-produces-triples-from-base-matrices
  (testing "multiplying base matrices by initial 3-4-5 triple produces more triples"
    (is (triple? (matrix-mult (first init-matrices) [3 4 5])))))
