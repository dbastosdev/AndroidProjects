package model;

//Todos esses atributos devem ser configurados de acordo com a resposta da api para que
    // funcione adequadamente. Se forem diferentes, o retrofit não saberá como retornar
    // os dados.

public class USDBRL{

        public String date;
        public double opening;
        public double closing;
        public double lowest;
        public double highest;
        public double volume;
        public double quantity;
        public int amount;
        public double avg_price;

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public double getOpening() {
                return opening;
        }

        public void setOpening(double opening) {
                this.opening = opening;
        }

        public double getClosing() {
                return closing;
        }

        public void setClosing(double closing) {
                this.closing = closing;
        }

        public double getLowest() {
                return lowest;
        }

        public void setLowest(double lowest) {
                this.lowest = lowest;
        }

        public double getHighest() {
                return highest;
        }

        public void setHighest(double highest) {
                this.highest = highest;
        }

        public double getVolume() {
                return volume;
        }

        public void setVolume(double volume) {
                this.volume = volume;
        }

        public double getQuantity() {
                return quantity;
        }

        public void setQuantity(double quantity) {
                this.quantity = quantity;
        }

        public int getAmount() {
                return amount;
        }

        public void setAmount(int amount) {
                this.amount = amount;
        }

        public double getAvg_price() {
                return avg_price;
        }

        public void setAvg_price(double avg_price) {
                this.avg_price = avg_price;
        }
}