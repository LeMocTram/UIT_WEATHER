package com.example.sampleproject.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Asset {
    @SerializedName("id")
    public String id;
    @SerializedName("version")
    public Integer version;
    @SerializedName("createdOn")
    public String createdOn;
    @SerializedName("name")
    public String name;
    @SerializedName("accessPublicRead")
    public Boolean accessPublicRead;
    @SerializedName("parentId")
    public String parentId;
    @SerializedName("realm")
    public String realm;
    @SerializedName("type")
    public String type;
    @SerializedName("path")
    public String[] path;
    @SerializedName("attributes")
    public Attributes attributes;

    public class Attributes {
        @SerializedName("sunIrradiance")
        public SunIrradiance sunIrradiance;
        @SerializedName("rainfall")
        public Rainfall rainfall;
        @SerializedName("notes")
        public Notes notes;
        @SerializedName("uVIndex")
        public UVIndex uVIndex;
        @SerializedName("sunAzimuth")
        public SunAzimuth sunAzimuth;
        @SerializedName("sunZenith")
        public SunZenith sunZenith;
        @SerializedName("temperature")
        public Temperature temperature;
        @SerializedName("humidity")
        public Humidity humidity;
        @SerializedName("weatherData")
        public WeatherData weatherData;
        @SerializedName("location")
        public Location location;
        @SerializedName("windDirection")
        public WindDirection windDirection;
        @SerializedName("windSpeed")
        public WindSpeed windSpeed;
        @SerializedName("sunAltitude")
        public SunAltitude sunAltitude;

        public class SunAltitude {
            @SerializedName("type")
            public String type;
            @SerializedName("value")
            public String value = null;
            @SerializedName("name")
            public String name;
            @SerializedName("meta")
            public Meta meta;
            @SerializedName("timestamp")
            public float timestamp;

            public String getType() {
                return type;
            }

            public String getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class WindSpeed {
            public String type;
            public float value;
            public String name;
            public Meta meta;
            public float timestamp;

            public String getType() {
                return type;
            }

            public float getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class WindDirection {
            public String type;
            public float value;
            public String name;
            public Meta meta;
            public float timestamp;

            public String getType() {
                return type;
            }

            public float getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class Location {
            public String type;
            public ValueLocation value;
            public String name;
            public float timestamp;

            public class ValueLocation {
                public Double[] coordinates ;
                public String type;

                public Double[] getCoordinates() {
                    return coordinates;
                }

                public String getType() {
                    return type;
                }
            }

            public String getType() {
                return type;
            }

            public ValueLocation getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class WeatherData {
            public String type;
            public ValueWeatherData valueWeatherData;
            public String name;
            public MetaWeatherData metaWeatherData;
            public float timestamp;

            public class MetaWeatherData {
                public AgentLink agentLink;
                public boolean accessPublicRead;
                public boolean readOnly;
                public ArrayList<Object> attributeLinks = new ArrayList<Object>();

                public class AgentLink {
                    public String id;
                    public float pollingMillis;
                    public String path;
                    public boolean messageConvertBinary;
                    public boolean messageConvertHex;
                    public String type;

                    public String getId() {
                        return id;
                    }

                    public float getPollingMillis() {
                        return pollingMillis;
                    }

                    public String getPath() {
                        return path;
                    }

                    public boolean isMessageConvertBinary() {
                        return messageConvertBinary;
                    }

                    public boolean isMessageConvertHex() {
                        return messageConvertHex;
                    }

                    public String getType() {
                        return type;
                    }
                }

                public AgentLink getAgentLink() {
                    return agentLink;
                }

                public boolean isAccessPublicRead() {
                    return accessPublicRead;
                }

                public boolean isReadOnly() {
                    return readOnly;
                }

                public ArrayList<Object> getAttributeLinks() {
                    return attributeLinks;
                }
            }

            public class ValueWeatherData {
                public float dt;
                public float id;
                public float cod;
                public Sys sys;
                public String base;
                public Main main;
                public String name;
                public Wind wind;
                public Coord coord;
                public Clouds clouds;
                public ArrayList<Object> weather = new ArrayList<Object>();
                public float timezone;
                public float visibility;

                public class Clouds {
                    public float all;

                    public float getAll() {
                        return all;
                    }
                }

                public class Coord {
                    public float lat;
                    public float lon;

                    public float getLat() {
                        return lat;
                    }

                    public float getLon() {
                        return lon;
                    }
                }

                public class Wind {
                    public float deg;
                    public float gust;
                    public float speed;

                    public float getDeg() {
                        return deg;
                    }

                    public float getGust() {
                        return gust;
                    }

                    public float getSpeed() {
                        return speed;
                    }
                }

                public class Main {
                    public float temp;
                    public float humidity;
                    public float pressure;
                    public float temp_max;
                    public float temp_min;
                    public float sea_level;
                    public float feels_like;
                    public float grnd_level;

                    public float getTemp() {
                        return temp;
                    }

                    public float getHumidity() {
                        return humidity;
                    }

                    public float getPressure() {
                        return pressure;
                    }

                    public float getTemp_max() {
                        return temp_max;
                    }

                    public float getTemp_min() {
                        return temp_min;
                    }

                    public float getSea_level() {
                        return sea_level;
                    }

                    public float getFeels_like() {
                        return feels_like;
                    }

                    public float getGrnd_level() {
                        return grnd_level;
                    }
                }

                public class Sys {
                    public float id;
                    public float type;
                    public float sunset;
                    public String country;
                    public float sunrise;

                    public float getId() {
                        return id;
                    }

                    public float getType() {
                        return type;
                    }

                    public float getSunset() {
                        return sunset;
                    }

                    public String getCountry() {
                        return country;
                    }

                    public float getSunrise() {
                        return sunrise;
                    }
                }

                public float getDt() {
                    return dt;
                }

                public float getId() {
                    return id;
                }

                public float getCod() {
                    return cod;
                }

                public Sys getSys() {
                    return sys;
                }

                public String getBase() {
                    return base;
                }

                public Main getMain() {
                    return main;
                }

                public String getName() {
                    return name;
                }

                public Wind getWind() {
                    return wind;
                }

                public Coord getCoord() {
                    return coord;
                }

                public Clouds getClouds() {
                    return clouds;
                }

                public ArrayList<Object> getWeather() {
                    return weather;
                }

                public float getTimezone() {
                    return timezone;
                }

                public float getVisibility() {
                    return visibility;
                }
            }

            public String getType() {
                return type;
            }

            public ValueWeatherData getValueWeatherData() {
                return valueWeatherData;
            }

            public String getName() {
                return name;
            }

            public MetaWeatherData getMetaWeatherData() {
                return metaWeatherData;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class Humidity {
            @SerializedName("type")
            public String type;
            @SerializedName("value")
            public float value;
            @SerializedName("name")
            public String name;
            @SerializedName("meta")
            public Meta meta;
            @SerializedName("timestamp")
            public float timestamp;


            public String getType() {
                return type;
            }

            public float getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class Temperature {
            public String type;
            public float value;
            public String name;
            public Meta meta;
            public float timestamp;

            public String getType() {
                return type;
            }

            public float getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class SunZenith {
            public String type;
            public String value = null;
            public String name;
            public Meta meta;
            public float timestamp;

            public String getType() {
                return type;
            }

            public String getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class SunAzimuth {
            public String type;
            public String value = null;
            public String name;
            public Meta meta;
            public float timestamp;

            public String getType() {
                return type;
            }

            public String getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class UVIndex {
            public String type;
            public String value = null;
            public String name;
            public MetaUVI meta;
            public float timestamp;
            public class MetaUVI {
                public boolean readOnly;
                public String label;

                public boolean isReadOnly() {
                    return readOnly;
                }

                public String getLabel() {
                    return label;
                }
            }

            public String getType() {
                return type;
            }

            public String getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public MetaUVI getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class Notes {
            public String type;
            public String value = null;
            public String name;
            public float timestamp;

            public String getType() {
                return type;
            }

            public String getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class Rainfall {
            public String type;
            public String value = null;
            public String name;
            public Meta meta;
            public float timestamp;

            public String getType() {
                return type;
            }

            public String getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class SunIrradiance {
            public String type;
            public String value = null;
            public String name;
            public Meta meta;
            public float timestamp;

            public String getType() {
                return type;
            }

            public String getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class Meta {
            public boolean readOnly;

            public boolean isReadOnly() {
                return readOnly;
            }
        }

        public SunIrradiance getSunIrradiance() {
            return sunIrradiance;
        }

        public Rainfall getRainfall() {
            return rainfall;
        }

        public Notes getNotes() {
            return notes;
        }

        public UVIndex getuVIndex() {
            return uVIndex;
        }

        public SunAzimuth getSunAzimuth() {
            return sunAzimuth;
        }

        public SunZenith getSunZenith() {
            return sunZenith;
        }

        public Temperature getTemperature() {
            return temperature;
        }

        public Humidity getHumidity() {
            return humidity;
        }

        public WeatherData getWeatherData() {
            return weatherData;
        }

        public Location getLocation() {
            return location;
        }

        public WindDirection getWindDirection() {
            return windDirection;
        }

        public WindSpeed getWindSpeed() {
            return windSpeed;
        }

        public SunAltitude getSunAltitude() {
            return sunAltitude;
        }
    }

    public String getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getName() {
        return name;
    }

    public Boolean getAccessPublicRead() {
        return accessPublicRead;
    }

    public String getParentId() {
        return parentId;
    }

    public String getRealm() {
        return realm;
    }

    public String getType() {
        return type;
    }

    public String[] getPath() {
        return path;
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
