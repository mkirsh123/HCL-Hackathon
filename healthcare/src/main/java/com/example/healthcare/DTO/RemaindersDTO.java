package com.example.healthcare.DTO;

import java.util.List;

public class RemaindersDTO {
        private List<String> items;
        private int total;
        private int returned;

        public List<String> getItems(){
            return items;
        }
        public int getTotal(){
            return total;
        }
        public int getReturned(){
            return returned;
        }
        public void setItems(List<String> items){
            this.items=items;
        }
        public void setTotal(int total){
            this.total=total;
        }
        public void setReturned(int returned){
            this.returned=returned;
        }
}
