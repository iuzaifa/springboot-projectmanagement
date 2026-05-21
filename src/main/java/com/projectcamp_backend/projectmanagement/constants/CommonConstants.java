package com.projectcamp_backend.projectmanagement.constants;

public class CommonConstants {

    public static final String BASE_URL = "/api/v1";

    // ---------------- AUTH ROUTES ----------------
    public static class Auth {

        public static final String ROOT = BASE_URL + "/auth";
        public static final String REGISTER = "/register";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String CURRENT_USER = "/current-user";
        public static final String CHANGE_PASSWORD = "/change-password";
        public static final String REFRESH_TOKEN = "/refresh-token";
        public static final String VERIFY_EMAIL = "/verify-email/{verificationToken}";
        public static final String FORGOT_PASSWORD = "/forgot-password";
        public static final String RESET_PASSWORD ="/reset-password/{resetToken}";
        public static final String RESEND_VERIFICATION = "/resend-email-verification";
    }


    // ---------------- USER ROUTES ----------------
    public static class User {
        public static final String ROOT = BASE_URL + "/users";
        // CRUD
        public static final String CREATE = "/";
        public static final String GET_ALL = "/";
        public static final String GET_BY_ID = "/{userId}";
        public static final String UPDATE = "/{userId}";
        public static final String DELETE = "/{userId}";
        // PROFILE
        public static final String PROFILE = "/profile";
        public static final String UPDATE_PROFILE = "/profile";
        // ACCOUNT
        public static final String ACTIVATE = "/{userId}/activate";
        public static final String DEACTIVATE = "/{userId}/deactivate";
        // SEARCH
        public static final String SEARCH = "/search";
        // ROLE
        public static final String CHANGE_ROLE = "/{userId}/role";
        // AVATAR
        public static final String UPLOAD_AVATAR = "/{userId}/avatar";
        public static final String DELETE_AVATAR = "/{userId}/avatar";
    }

    // ---------------- PROJECT ROUTES ----------------
    public static class Projects {

        public static final String ROOT = BASE_URL + "/projects";
        public static final String LIST = "/";
        public static final String CREATE = "/";
        public static final String DETAILS = "/{projectId}";
        public static final String UPDATE = "/{projectId}";
        public static final String DELETE = "/{projectId}";
        public static final String MEMBERS ="/{projectId}/members";
        public static final String ADD_MEMBER ="/{projectId}/members";
        public static final String UPDATE_MEMBER ="/{projectId}/members/{userId}";
        public static final String REMOVE_MEMBER ="/{projectId}/members/{userId}";
    }

    // ---------------- TASK ROUTES ----------------
    public static class Tasks {

        public static final String ROOT = BASE_URL + "/tasks";
        public static final String LIST = "/{projectId}";
        public static final String CREATE = "/{projectId}";
        public static final String DETAILS ="/{projectId}/t/{taskId}";
        public static final String UPDATE ="/{projectId}/t/{taskId}";
        public static final String DELETE ="/{projectId}/t/{taskId}";
        public static final String CREATE_SUBTASK ="/{projectId}/t/{taskId}/subtasks";
        public static final String UPDATE_SUBTASK ="/{projectId}/st/{subTaskId}";
        public static final String DELETE_SUBTASK ="/{projectId}/st/{subTaskId}";
    }

    // ---------------- NOTES ROUTES ----------------
    public static class Notes {
        public static final String ROOT = BASE_URL + "/notes";
        public static final String LIST = "/{projectId}";
        public static final String CREATE = "/{projectId}";
        public static final String DETAILS ="/{projectId}/n/{noteId}";
        public static final String UPDATE ="/{projectId}/n/{noteId}";
        public static final String DELETE ="/{projectId}/n/{noteId}";
    }

    // ---------------- HEALTH CHECK ----------------
    public static class Health {

        public static final String ROOT =BASE_URL + "/healthcheck";
        public static final String STATUS = "/";
    }
}