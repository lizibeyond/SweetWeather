package com.example.sweetweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Lizi
 * PS: 天气数据类
 */
public class Weather {

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
        private Realtime realtime;

        public Realtime getRealtime() {
            return realtime;
        }

        public void setRealtime(Realtime realtime) {
            this.realtime = realtime;
        }

        public class Realtime{
            private String skycon;
            private Double temperature;
            @SerializedName("air_quality")
            private AirQuality airQuality;

            public String getSkycon() {
                return skycon;
            }

            public void setSkycon(String skycon) {
                this.skycon = skycon;
            }

            public Double getTemperature() {
                return temperature;
            }

            public void setTemperature(Double temperature) {
                this.temperature = temperature;
            }

            public AirQuality getAirQuality() {
                return airQuality;
            }

            public void setAirQuality(AirQuality airQuality) {
                this.airQuality = airQuality;
            }

            public class AirQuality{
                private Aqi aqi;

                public Aqi getAqi() {
                    return aqi;
                }

                public void setAqi(Aqi aqi) {
                    this.aqi = aqi;
                }

                public class Aqi{
                    private String chn;

                    public String getChn() {
                        return chn;
                    }

                    public void setChn(String chn) {
                        this.chn = chn;
                    }
                }
            }
        }
    }

}
