package com.wso2.org;

import com.wso2.org.DatabaseHandler.RepositoryManager;
import com.wso2.org.Models.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class UpdateIntoDatabase {

    static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {

        properties.load(UpdateIntoDatabase.class.getClassLoader().getResourceAsStream("config.properties"));
        ArrayList<Component> components = new ArrayList<>();

        components.addAll(GitHubRepoLister.getGitHubRepos(properties.getProperty("organization1"),1));
        components.addAll(GitHubRepoLister.getGitHubRepos(properties.getProperty("organization2"),2));
        components.addAll(GitHubRepoLister.getGitHubRepos(properties.getProperty("organization3"),3));

        RepositoryManager repositoryManager = new RepositoryManager();

        for (Component component : components) {

            RepositoryManager.insertComponent(component);

        }



    }




}

