package com.joaoiora.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.joaoiora.model.Customer;
import com.joaoiora.service.CustomerService;

/**
 * @author João Iora
 */
@Service
public class CustomerServiceRestImpl
  implements CustomerService {

  /**
   *
   */
  private static final Logger LOG = Logger
      .getLogger(CustomerServiceRestImpl.class.getName());

  /**
   *
   */
  private final RestTemplate restTemplate;

  /**
   *
   */
  private final String crmRestUrl;

  /**
   * @param restTemplate
   * @param crmRestUrl
   */
  @Autowired
  public CustomerServiceRestImpl(RestTemplate restTemplate,
                                 @Value(value = "${crm.rest.url}") String crmRestUrl) {
    super();
    this.restTemplate = restTemplate;
    this.crmRestUrl = crmRestUrl;
  }

  @Override
  public List<Customer> getCustomers() {
    LOG.info("in getCustomers(): Calling REST API " +
             crmRestUrl);
    final var response = restTemplate.exchange(crmRestUrl,
                                               HttpMethod.GET,
                                               null,
                                               new ParameterizedTypeReference<List<Customer>>() {
                                               });
    final var customers = response.getBody();
    LOG.info("in getCustomers(): customers" +
             customers);
    return customers;
  }

  @Override
  public void saveCustomer(Customer customer) {
    LOG.info("in saveCustomer(): Calling REST API " +
             crmRestUrl);
    final var id = customer.getId();
    if (id == null) {
      restTemplate.postForEntity(crmRestUrl,
                                 customer,
                                 String.class);
    }
    else {
      restTemplate.put(crmRestUrl,
                       customer);
    }
    LOG.info("in saveCustomer(): success");
  }

  @Override
  public Customer getCustomer(int id) {
    LOG.info("in getCustomer(): Calling REST API " +
             crmRestUrl);
    final var customer = restTemplate.getForObject(crmRestUrl +
                                                   "/" +
                                                   id,
                                                   Customer.class);
    LOG.info("in saveCustomer(): customer=" +
             customer);
    return customer;
  }

  @Override
  public void deleteCustomer(int id) {
    LOG.info("in deleteCustomer(): Calling REST API " +
             crmRestUrl);
    restTemplate.delete(crmRestUrl +
                        "/" +
                        id);
    LOG.info("in deleteCustomer(): deleted customer id=" +
             id);
  }

}
