(defproject cloverage-bug "0.1.0-SNAPSHOT"
  :description "Minimal setup for a java interop bug causing wrong function to be called."

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [cloverage "1.1.1"]]

  :profiles {:dev {:source-paths ["src" "dev"]}})

