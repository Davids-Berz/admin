package utilidades;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.math.NumberUtils.isDigits;

public final class JsonNodeUtils {
    /*
    private final static String SCRIPT_SELECTOR = "script";
    private static final String SCRIPT_KEY = "offers";

    public static Function<Element, String> getScriptElement(final String scriptText) {
        return element -> {
            if (element == null) return null;
            Elements scriptElements = toElements(SCRIPT_SELECTOR).apply(element);
            for (Element scriptElement : scriptElements) {
                String scriptData = scriptElement.data();
                if (contains(scriptData, scriptText)) {
                    scriptData=scriptData.replaceAll("\\n", "").replaceAll("\\t", "").replaceAll("\\r", "");
                    return scriptData;
                }
            }
            return null;
        };
    }

    public static Function<Element, String> getScriptElement() {
        return element -> {
            if (element == null) return null;
            Element noScriptElement = toElements("noscript").apply(element).first();
            Element noScriptIframe = toElements("iframe").apply(noScriptElement).first();
            String noScriptData = JSoupAttributes.fromAttribute("src").apply(noScriptIframe);
            return noScriptData;
        };
    }

    public static Function<Element, String> getScriptCategoryId() {
        return element -> {
            if (element == null) return null;
            Elements scriptElements = toElements("script").apply(element);
            for (Element scriptElement : scriptElements) {
                String scriptData = scriptElement.data();
                if (contains(scriptData, "searchData.p.categoryId")) {
                    return scriptData;
                }
            }
            return null;
        };
    }

    public static JsonNode getOfferNode(Element element) {
        String dataOffer = JsonNodeUtils.getScriptElement(SCRIPT_KEY).apply(element);
        dataOffer = dataOffer.replace("\n", "").replace("  ", "").replace("\\", "\\\\");
        return JsonNodeUtils.stringToJsonNode().apply(dataOffer);
    }

    public static Function<String, JsonNode> stringToJsonNode() {
        return rawJson -> {
            try {
                return isBlank(rawJson) ? null : new ObjectMapper().readTree(rawJson);
            } catch (IOException e) {
                return null;
            }
        };
    }

    public static JsonNode fromJsonSelector(JsonNode jsonNode,
                                            final String selector) {
        if (jsonNode == null || isBlank(selector))
            return null;

        final String[] splitSelector = selector.split(">");

        for (String key : splitSelector) {
            key = trim(key);

            if (StringUtils.equals(key, "*"))
                key = extractEquivalentKey(jsonNode);

            if (isBlank(key))
                return null;

            if (jsonNode.isArray() && isDigits(key)) {
                jsonNode = jsonNode.path(parseInt(key));
                continue;
            }

            jsonNode = jsonNode.path(key);
        }

        return jsonNode;
    }

    private static String extractEquivalentKey(final JsonNode jsonNode) {
        if (jsonNode == null)
            return null;

        Iterator<String> keys = jsonNode.fieldNames();
        if (keys == null) return null;

        return keys.hasNext() ?
                keys.next() :
                null;
    }

    public static String extractValue(final JsonNode jsonNode,
                                      final String jsonSelector) {
        final JsonNode child = fromJsonSelector(jsonNode, jsonSelector);
        return child != null ?
                child.asText() :
                null;
    }*/
}
