package com.example.neha.p1_popularmovies.Data;

import io.realm.RealmObject;

/**
 * Created by neha on 10/23/16.
 */

public class ReviewResult extends RealmObject{


        private String id;
        private String author;
        private String content;
        private String url;

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The author
         */

        public String getAuthor() {
            return author;
        }

        /**
         *
         * @param author
         * The author
         */

        public void setAuthor(String author) {
            this.author = author;
        }

        /**
         *
         * @return
         * The content
         */
        public String getContent() {
            return content;
        }

        /**
         *
         * @param content
         * The content
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }


}
