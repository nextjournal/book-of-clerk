(ns builder
  (:require [babashka.fs :as fs]
            [clojure.java.io :as io]))

(defn copy-files! []
  (let [clerk-root (-> (io/resource "nextjournal/clerk.clj") fs/parent fs/parent fs/parent)]
    (fs/copy (fs/file clerk-root "book.clj") (fs/file "index.clj") #{:replace-existing})
    (fs/copy (fs/file clerk-root "book.clj") (fs/file "book.clj") #{:replace-existing})
    (fs/copy (fs/file clerk-root "chinook.db") (fs/file "chinook.db") #{:replace-existing})))

(defn copy-files+get-paths []
  (copy-files!)
  ["index.clj"])
