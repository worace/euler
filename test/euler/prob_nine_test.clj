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
    (is (every? triple? (map (fn [m] (matrix-mult m [3 4 5])) init-matrices)))))

(deftest test-produces-new-triples-from-a-seed
  (testing "given seed triple it makes 3 new one"
    (is (= 3 (count (child-triples [3 4 5]))))
    (is (every? triple? (child-triples [3 4 5])))))

(deftest test-produces-n-iterations-when-asked
  (testing "given a triple and n it finds that # of generations"
    (is (= 1 (count (child-triples [3 4 5] 0))))
    (is (= 3 (count (child-triples [3 4 5] 1))))
    (is (= 9 (count (child-triples [3 4 5] 2))))
    (is (= 27 (count (child-triples [3 4 5] 3))))
    (is (every? triple? (child-triples [3 4 5] 5)))))

(deftest test-triple-summing-to
  (testing "given a target sum, finds a triple summing to that number"
    (is (= [3 4 5] (triple-summing-to 12)))
    (is (= [7 24 25] (triple-summing-to 56)))
    (is (= [375 200 425] (triple-summing-to 1000)))))

(deftest test-factored-triple
  (testing "it multiplies a triple by appropriate factor to match target"
    (is (= [6 8 10] (triple-scaled-to 24 [3 4 5])))))

