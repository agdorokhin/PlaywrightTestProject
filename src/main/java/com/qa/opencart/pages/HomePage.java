package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    //1. String Locators - Object Repository
    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchPageHeader = "div#content h1";

    //2. Page constructor
    public HomePage(Page page) {
        this.page = page;
    }

    //3. Page actions/methods
    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("page title is: " + title);
        return title;
    }

    public String getHomePageURL() {
        String url = page.url();
        System.out.println("URL is: " + url);
        return url;
    }

    public String doSearch(String productName) {
        page.fill(search, productName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.println("search header is: " + header);
        return header;
    }

}
