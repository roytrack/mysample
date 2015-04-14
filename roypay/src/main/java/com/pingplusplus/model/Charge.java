package com.pingplusplus.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.LongSerializationPolicy;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.net.APIResource;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
public class Charge extends APIResource implements MetadataStore<Charge> {
    String id;
    String object;
    Long created;
    Boolean livemode;
    Boolean paid;
    Boolean refunded;
    Object app;
    String channel;
    String orderNo;
    String clientIp;
    Integer amount;
    Integer amountSettle;
    String currency;
    String subject;
    String body;
    Long timePaid;
    Long timeExpire;
    Long timeSettle;
    String transactionNo;
    ChargeRefundCollection refunds;
    Integer amountRefunded;
    String failureCode;
    String failureMsg;
    Map<String, String> metadata;
    Map<String, Object> credential;
    Map<String, String> extra;
    String description;

    public static final Gson PRETTY_PRINT_GSON = new GsonBuilder().
            setPrettyPrinting().
            serializeNulls().
            disableHtmlEscaping().
            setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
            setLongSerializationPolicy(LongSerializationPolicy.STRING).
            registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
                @Override
                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src == src.longValue())
                        return new JsonPrimitive(src.longValue());
                    return new JsonPrimitive(src);
                }
            }).
            create();


    public ChargeRefundCollection getRefunds() {
        // API versions 2014-05-19 and earlier render charge refunds as an array
        // instead of an object, meaning there is no sublist URL.
        if (refunds.getURL() == null) {
            refunds.setURL(String.format("/v1/charges/%s/refunds", getId()));
        }
        return refunds;
    }




    public String getCredential() {
        Map<String, Object> credParams = new HashMap<String, Object>();
        if (!credential.isEmpty()) {
            credParams.put("object", "credential");
            credParams.put(channel, credential.get(channel));
        }
        return PRETTY_PRINT_GSON.toJson(credParams);
    }



    public static Charge create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return create(params, null);
    }

    public static Charge retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        return retrieve(id, null, null);
    }

    public static Charge retrieve(String id, Map<String, Object> params) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        return retrieve(id, params, null);
    }

    public Charge update(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return update(params, null);
    }

    public static ChargeCollection all(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return all(params, null);
    }

    public static Charge create(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(RequestMethod.POST, classURL(Charge.class), params,
                Charge.class, apiKey);
    }

    public static Charge retrieve(String id, Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(RequestMethod.GET, instanceURL(Charge.class, id), params,
                Charge.class, apiKey);
    }

    public Charge update(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(RequestMethod.POST, instanceURL(Charge.class, id), params,
                Charge.class, apiKey);
    }

    public static ChargeCollection all(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(RequestMethod.GET, classURL(Charge.class), params,
                ChargeCollection.class, apiKey);
    }
}
