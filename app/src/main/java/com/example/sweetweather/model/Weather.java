package com.example.sweetweather.model;

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
            private String temperature;
            private AirQuality airQuality;

            public String getSkycon() {
                return skycon;
            }

            public void setSkycon(String skycon) {
                this.skycon = skycon;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public AirQuality getAirQuality() {
                return airQuality;
            }

            public void setAirQuality(AirQuality airQuality) {
                this.airQuality = airQuality;
            }

            public class AirQuality{
                private Api api;

                public Api getApi() {
                    return api;
                }

                public void setApi(Api api) {
                    this.api = api;
                }

                public class Api{
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
