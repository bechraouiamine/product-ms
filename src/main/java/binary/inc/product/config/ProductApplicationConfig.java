package binary.inc.product.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

import static jakarta.servlet.DispatcherType.ERROR;
import static jakarta.servlet.DispatcherType.FORWARD;

@Configuration
/*@EnableWebSecurity*/ public class ProductApplicationConfig {

    /*@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow all endpoints
                  .allowedOrigins("http://localhost:8080", "https://yourdomain.com") // Allow specific origins
                  .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow specific HTTP methods
                  .allowedHeaders("*") // Allow all headers
                  .allowCredentials(true) // Allow cookies
                  .maxAge(3600); // Cache preflight response for 1 hour
            }
        };
    }*/

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
          .addSecurityItem(new SecurityRequirement().addList("keycloak"))
          .components(new io.swagger.v3.oas.models.Components()
            .addSecuritySchemes("keycloak", new SecurityScheme()
              .type(SecurityScheme.Type.OAUTH2)
              .description("Keycloak OAuth2 Authentication")
              .flows(new OAuthFlows()
                .authorizationCode(new OAuthFlow()
                  .authorizationUrl("http://localhost:8080/realms/product-realm/protocol/openid-connect/auth")
                  .tokenUrl("http://localhost:8080/realms/product-realm/protocol/openid-connect/token")
                  .scopes(new Scopes()
                    .addString("openid", "OpenID Connect scope")
                    .addString("profile", "Profile scope")
                    .addString("email", "Email scope")
                  )
                )
              )
            )
          );
    }


    /*
    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "OAuth2";

        return new OpenAPI()
                .info(new Info().title("API Documentation")
                        .description("API documentation with OAuth2")
                        .version("v1.0"))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.OAUTH2)
                                .flows(new io.swagger.v3.oas.models.security.OAuthFlows()
                                        .authorizationCode(new io.swagger.v3.oas.models.security.OAuthFlowAuthorizationCode()
                                                .authorizationUrl("https://your-auth-server.com/oauth/authorize")
                                                .tokenUrl("https://your-auth-server.com/oauth/token"))));
    }

    @Bean
    public HttpSecurity security(HttpSecurity http) throws Exception {
        http
                .oauth2Login(Customizer.withDefaults())

                .oauth2Login() // Enable OAuth2 login
                .authorizationEndpoint()
                .baseUri("/oauth2/authorize") // Point to your OAuth provider's authorization endpoint
                .and()
                .oauth2Client()
                .and()
                .authorizeRequests()
                .antMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll() // Allow access to Swagger UI
                .anyRequest().authenticated(); // Protect other endpoints
        return http;
    }*/

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize.dispatcherTypeMatchers(FORWARD, ERROR)
          .permitAll()
          .requestMatchers("/swagger-ui/**", "v3/api-´´docs/swagger-config", "v3/api-docs", "v3/api-docs/swagger-config", "/product/**", "/hostname/**")
          .permitAll()
          .anyRequest()
          .denyAll());


        return http.build();
    }
/*
    private CorsConfigurationSource allowCors() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
        configuration.setAllowedOrigins(Collections.singletonList("*")); // Allow all origins
        configuration.setAllowedMethods(Collections.singletonList("*")); // Allow all HTTP methods
        configuration.setAllowedHeaders(Collections.singletonList("*")); // Allow all headers
        configuration.setAllowCredentials(false); // Do not allow credentials for wildcard origins

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Apply to all endpoints
        return source;
    }*/
}
