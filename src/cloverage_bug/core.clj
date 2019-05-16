(ns cloverage-bug.core)

;; breaks when reading tests
;(def perform-interop (String. ""))

;; breaks when running tests
(defn perform-interop [] (String. ""))

(def new clojure.core/identity)
