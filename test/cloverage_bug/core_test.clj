(ns cloverage-bug.core-test
  (:require
   [clojure.test :refer :all]
   [cloverage-bug.core :as sut]))

(deftest perform-interop
  (is (sut/perform-interop)))

(deftest new
  (is (= 6 (sut/new 6))))
