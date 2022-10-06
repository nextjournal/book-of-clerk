(ns builder
  (:require [babashka.fs :as fs]
            [clojure.java.io :as io]))

(defn copy-book! [_]
  (let [clerk-root (-> (io/resource "nextjournal/clerk.clj") fs/parent fs/parent fs/parent)]
    (fs/copy (fs/file clerk-root "book.clj") (fs/file "book.clj") #{:replace-existing})
    (println "Copied" (str (fs/file clerk-root "book.clj")))))
