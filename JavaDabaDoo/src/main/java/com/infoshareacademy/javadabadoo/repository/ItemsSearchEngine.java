package com.infoshareacademy.javadabadoo.repository;

        import com.infoshareacademy.javadabadoo.model.Item;
        import com.infoshareacademy.javadabadoo.model.Library;
        import com.infoshareacademy.javadabadoo.model.Language;
        import com.infoshareacademy.javadabadoo.model.User;

        import java.util.List;

public class ItemSearchEngine {
    public Item search(SearchParameters params) {
        List<Library> libs = new List<Library>(); //prosze o podpowiedz

        for(Library lib : libs) {
            User u = lib.getUser();
            if(u.equals(params.author)) {
                List<Item> items = lib.getItems();
                for(Item i : items) {
                    String itemTitle = i.getTitle();
                    Language itemLanguage = i.getLanguage();
                    if(itemTitle == params.title && itemLanguage == params.language) {
                        return i;
                    }
                }
            }
        }

        return null;
    }

    public class SearchParameters {
        private String title ;
        private String author;
        private Language language;

        public SearchParameters(String title, String author, Language language) {
            this.title = title;
            this.author = author;
            this.language = language;
        }

        public String getTitle() {
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public Language getLanguage() {
            return language;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public void setLanguage(Language language) {
            this.language = language;
        }
    }
}
