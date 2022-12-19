package com.example.sampleproject.Model;

import java.util.ArrayList;

public class Agent {
    public String id;
    public float version;
    public float createdOn;
    public String name;
    public boolean accessPublicRead;
    public String realm;
    public String type;
    public String[] path;
    public AttributesAgent attributes;

    public class AttributesAgent {
        public RequestQueryParameters requestQueryParameters;
        public BaseURL baseURL;
        public RequestTimeoutMillis requestTimeoutMillis;
        public Notes notes;
        public RequestHeaders requestHeaders;
        public FollowRedirects followRedirects;
        public Location location;
        public AgentDisabled agentDisabled;
        public AgentStatus agentStatus;
        public PollingMillis pollingMillis;
        public class PollingMillis {
            public String type;
            public float value;
            public String name;
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

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class AgentStatus {
            public String type;
            public String value;
            public String name;
            public Meta meta;
            public float timestamp;
            public class Meta {
                public boolean readOnly;

                public boolean isReadOnly() {
                    return readOnly;
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

            public Meta getMeta() {
                return meta;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class AgentDisabled {
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
        public class Location {
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
        public class FollowRedirects {
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
        public class RequestHeaders {
            public String type;
            public Value ValueObject;
            public String name;
            public float timestamp;

            public String getType() {
                return type;
            }

            public Value getValueObject() {
                return ValueObject;
            }

            public String getName() {
                return name;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class Value {
           public String[] Accept ;

            public String[] getAccept() {
                return Accept;
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
        public class RequestTimeoutMillis {
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
        public class BaseURL {
            public String type;
            public String value;
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
        public class RequestQueryParameters {
            public String type;
            public Value2 value;
            public String name;
            public float timestamp;

            public String getType() {
                return type;
            }

            public Value2 getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public float getTimestamp() {
                return timestamp;
            }
        }
        public class Value2 {
            public String[] appid;
            public Double[] lon;
            public String[] units;
            public Double[] lat;

            public String[] getAppid() {
                return appid;
            }

            public Double[] getLon() {
                return lon;
            }

            public String[] getUnits() {
                return units;
            }

            public Double[] getLat() {
                return lat;
            }
        }

        public RequestQueryParameters getRequestQueryParameters() {
            return requestQueryParameters;
        }

        public BaseURL getBaseURL() {
            return baseURL;
        }

        public RequestTimeoutMillis getRequestTimeoutMillis() {
            return requestTimeoutMillis;
        }

        public Notes getNotes() {
            return notes;
        }

        public RequestHeaders getRequestHeaders() {
            return requestHeaders;
        }

        public FollowRedirects getFollowRedirects() {
            return followRedirects;
        }

        public Location getLocation() {
            return location;
        }

        public AgentDisabled getAgentDisabled() {
            return agentDisabled;
        }

        public AgentStatus getAgentStatus() {
            return agentStatus;
        }

        public PollingMillis getPollingMillis() {
            return pollingMillis;
        }
    }
}
