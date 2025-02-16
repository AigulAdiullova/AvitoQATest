public class Item {

    // Поля класса
    private String createdAt;
    private String id;
    private String name;
    private int price;
    private int sellerId;
    private Statistics statistics;

    // Геттеры и сеттеры для каждого поля

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    // Вложенный класс для статистики
    public static class Statistics {
        private int contacts;
        private int likes;
        private int viewCount;

        // Геттеры и сеттеры для статистики

        public int getContacts() {
            return contacts;
        }

        public void setContacts(int contacts) {
            this.contacts = contacts;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }
    }
}