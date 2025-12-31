(defproject org.openvoxproject/clj-shell-utils "2.0.2"
  :description "Clojure shell execution utilities"

  :min-lein-version "2.9.0"

  :parent-project {:coords [org.openvoxproject/clj-parent "7.5.1"]
                   :inherit [:managed-dependencies]}
  :license {:name "Apache-2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0.txt"}
            
  :pedantic? :abort

  :test-paths ["test/unit"]

  :plugins [[lein-project-version "0.1.0"]
            [lein-parent "0.3.6"]
            [org.openvoxproject/i18n "0.9.4"]]

  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]

  :dependencies [[org.clojure/clojure]
                 [prismatic/schema]
                 [org.apache.commons/commons-exec]
                 [commons-io]
                 [org.slf4j/log4j-over-slf4j]
                 [org.slf4j/slf4j-api]
                 [org.openvoxproject/trapperkeeper]
                 [org.openvoxproject/kitchensink]
                 [org.openvoxproject/i18n]]



  :profiles { :test { :dependencies [[org.openvoxproject/trapperkeeper nil :classifier "test" :scope "test"]]}}

  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/CLOJARS_USERNAME
                                     :password :env/CLOJARS_PASSWORD
                                     :sign-releases false}]])
