(def slf4j-version "2.0.17")
(def trapperkeeper-version "4.3.0")

(defproject org.openvoxproject/clj-shell-utils "2.1.1-SNAPSHOT"
  :description "Clojure shell execution utilities"

  :min-lein-version "2.9.0"

  :license {:name "Apache-2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0.txt"}
            
  :pedantic? :abort

  :test-paths ["test/unit"]

  :plugins [[lein-project-version "0.1.0"]
            [org.openvoxproject/i18n "1.0.3"]]

  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]

  ;; These are to enforce consistent versions across dependencies of dependencies,
  ;; and to avoid having to define versions in multiple places. If a component
  ;; defined under :dependencies ends up causing an error due to :pedantic? :abort,
  ;; because it is a dep of a dep with a different version, move it here.
  :managed-dependencies [[org.clojure/clojure "1.12.4"]
                         [org.clojure/tools.logging "1.3.1"]

                         [clj-time "0.15.2"]

                         [org.openvoxproject/trapperkeeper ~trapperkeeper-version]
                         [org.openvoxproject/trapperkeeper ~trapperkeeper-version :classifier "test"]]

  :dependencies [[org.clojure/clojure]
                 [prismatic/schema "1.4.1"]
                 [org.apache.commons/commons-exec "1.6.0"]
                 [commons-io "2.21.0"]
                 [org.slf4j/log4j-over-slf4j ~slf4j-version]
                 [org.slf4j/slf4j-api ~slf4j-version]
                 [org.openvoxproject/trapperkeeper]
                 [org.openvoxproject/kitchensink "3.5.4"]
                 [org.openvoxproject/i18n "1.0.3"]]



  :profiles { :test { :dependencies [[org.openvoxproject/trapperkeeper :classifier "test" :scope "test"]]}}

  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/CLOJARS_USERNAME
                                     :password :env/CLOJARS_PASSWORD
                                     :sign-releases false}]])
