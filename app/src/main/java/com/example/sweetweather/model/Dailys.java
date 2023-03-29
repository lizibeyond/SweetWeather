package com.example.sweetweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * @author Lizi
 * PS: 未来天气数据类
 */
public class Dailys {
    private String status;
    private Result result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result{
        private Daily daily;

        public Daily getDaily() {
            return daily;
        }

        public void setDaily(Daily daily) {
            this.daily = daily;
        }

        public class Daily{
            private List<Temperature> temperature;
            private List<Skycon> skycon;
            @SerializedName("life_index")
            private LifeIndex lifeIndex;

            public List<Temperature> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<Temperature> temperature) {
                this.temperature = temperature;
            }

            public List<Skycon> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<Skycon> skycon) {
                this.skycon = skycon;
            }

            public LifeIndex getLifeIndex() {
                return lifeIndex;
            }

            public void setLifeIndex(LifeIndex lifeIndex) {
                this.lifeIndex = lifeIndex;
            }

            public class LifeIndex{
                private List<Desc> coldRisk;
                private List<Desc> carWashing;
                private List<Desc> ultraviolet;
                private List<Desc> dressing;

                public List<Desc> getColdRisk() {
                    return coldRisk;
                }

                public void setColdRisk(List<Desc> coldRisk) {
                    this.coldRisk = coldRisk;
                }

                public List<Desc> getCarWashing() {
                    return carWashing;
                }

                public void setCarWashing(List<Desc> carWashing) {
                    this.carWashing = carWashing;
                }

                public List<Desc> getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(List<Desc> ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public List<Desc> getDressing() {
                    return dressing;
                }

                public void setDressing(List<Desc> dressing) {
                    this.dressing = dressing;
                }
            }


        }
        public class Desc{
            private String desc;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

        public class Temperature{
            private Float max;
            private Float min;

            public Float getMax() {
                return max;
            }

            public void setMax(Float max) {
                this.max = max;
            }

            public Float getMin() {
                return min;
            }

            public void setMin(Float min) {
                this.min = min;
            }
        }

        public class Skycon{
            private String value;
            private Date date;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Date getDate() {
                return date;
            }

            public void setDate(Date date) {
                this.date = date;
            }
        }

    }
}
